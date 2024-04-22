#!/bin/bash

# Read the CSV file and migrate SparkOps to SubdomainOps
while IFS=, read -r spark_op_path subdomain_name
do
    # Trim whitespace and remove quotes
    spark_op_path=$(echo $spark_op_path | xargs | sed -e 's/^"//' -e 's/"$//')
    subdomain_name=$(echo $subdomain_name | xargs | sed -e 's/^"//' -e 's/"$//')

    # Define the source and target paths
    src_path="src/main/scala/$spark_op_path"
    target_path="subdomains/${subdomain_name}/src/main/scala/legacy"

    # Create the target directory if it doesn't exist
    mkdir -p "$target_path"
    if [ $? -ne 0 ]; then
        echo "Failed to create target directory: $target_path"
        continue
    fi

    # Extract the SparkOp class name from the path
    class_name=$(basename $spark_op_path .scala)

    # Read the content of the SparkOp Scala file
    if [ ! -f "$src_path" ]; then
        echo "Source SparkOp file does not exist: $src_path"
        continue
    fi
    spark_op_content=$(<"$src_path")

    # Replace string inputs with Input types and hardcode inter-subdomain references
    subdomain_op_content=$(echo "$spark_op_content" | sed -e 's/String/Input/g' -e 's/import something.myclass/"HardcodedName"/g')

    # Write the updated content to the new SubdomainOp Scala file
    echo "$subdomain_op_content" > "$target_path/$class_name.scala"
    if [ $? -ne 0 ]; then
        echo "Failed to write to SubdomainOp file: $target_path/$class_name.scala"
        continue
    fi

    echo "Migrated $class_name to $subdomain_name"
done < migrations.csv
