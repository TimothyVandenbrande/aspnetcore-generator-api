# Build stage
FROM microsoft/aspnetcore-build:2 as build-env
WORKDIR /api
COPY *.csproj .
RUN dotnet restore
COPY . .
RUN dotnet publish -o /publish

# Runtime stage
FROM microsoft/aspnetcore:2 as run-env
WORKDIR /publish
COPY --from=build-env /publish .
ENTRYPOINT ["dotnet", "api.dll"]