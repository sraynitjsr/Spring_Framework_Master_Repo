#!/bin/bash

# OAuth2 Client Details
client_id="my-client-id"
client_secret="my-client-secret"
token_uri="my-token-uri"
scope="read write"

# Step 1: Obtain Access Token
access_token=$(curl -s -X POST -u "$client_id:$client_secret" \
  -d "grant_type=client_credentials&scope=$scope" \
  "$token_uri" | jq -r '.access_token')

# Check if access token is obtained successfully
if [ -z "$access_token" ]; then
  echo "Error obtaining access token."
  exit 1
fi

# Step 2: Make a Request Using the Access Token
resource_url="https://api.example.com/resource"
response=$(curl -s -H "Authorization: Bearer $access_token" "$resource_url")

# Process the response
if [ $? -eq 0 ]; then
  echo "Response from $resource_url:"
  echo "$response"
else
  echo "Error making request to $resource_url."
fi

# Step 3: Make Another Request Using the Same Access Token
another_resource_url="https://api.example.com/another-resource"
another_response=$(curl -s -H "Authorization: Bearer $access_token" "$another_resource_url")

# Process the response for the second request
if [ $? -eq 0 ]; then
  echo "Response from $another_resource_url:"
  echo "$another_response"
else
  echo "Error making request to $another_resource_url."
fi
