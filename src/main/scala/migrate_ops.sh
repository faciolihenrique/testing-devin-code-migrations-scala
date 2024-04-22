for file in legacy/*.scala; do
  base=$(basename $file)
  cp $file subdomain/Subdomain$base
done
