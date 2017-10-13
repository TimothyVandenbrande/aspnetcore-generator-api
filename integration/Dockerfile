FROM microsoft/dotnet:2-sdk
WORKDIR /integration

COPY *.csproj .
# RUN dotnet restore

COPY . .
ENTRYPOINT ["dotnet", "test"]
