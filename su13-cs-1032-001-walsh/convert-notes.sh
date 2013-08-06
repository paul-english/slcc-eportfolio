for file in linux-notes/*.html
do
  title="${file:15}"
  title=${title//.html/}
  title=${title//-/ }
  capitalized=""
  for i in $title;
  do
      B=`echo "${i:0:1}" | tr "[:lower:]" "[:upper:]"`;
      capitalized="$capitalized ${B}${i:1}"
  done
  echo $capitalized
  echo "---\nlayout: page\ntitle: ${capitalized}\n---" > ${file//.html/.md}
  python html2text.py $file | tail -n+2 >> ${file//.html/.md}
done
