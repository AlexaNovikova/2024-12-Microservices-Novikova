#!/bin/bash

# API endpoint
url="http://arch.homework/user/1"

# Number of requests to send
num_requests=2000

# Send requests and measure response time
for (( i=1; i<=$num_requests; i++ )); do
    echo "Sending request $i..."
    response=$(curl -s -w "\n%{time_total}s\n" $url)
    response_time=$(echo "$response" | tail -n 1)
    echo "Response time: $response_time"
done
