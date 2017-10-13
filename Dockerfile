# Build stage
FROM microsoft/aspnetcore-build:2 AS build-env


WORKDIR /generator

## restore
COPY api/api.csproj ./api/
RUN dotnet restore api/api.csproj
COPY tests/tests.csproj ./tests/
RUN dotnet restore tests/tests.csproj

## copy source
COPY . .

## test
RUN dotnet test tests/tests.csproj

## publish
ENV TEAMCITY_PROJECT_NAME=fake
RUN dotnet publish api/api.csproj -o /publish

# Runtime stage
FROM microsoft/aspnetcore:2 AS run-env
WORKDIR /publish
COPY --from=build-env /publish /publish
WORKDIR /publish
ENTRYPOINT ["dotnet", "api.dll"]