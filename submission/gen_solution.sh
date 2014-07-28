#/bin/sh

if [ -f submission*.zip ]; then
	rm submission*.zip
fi

# date
TESTDATE=$(date +"%Y-%m-%dT%H-%M-%S")

zip -r submission_${TESTDATE} README.md code solution
openssl sha1 submission*.zip
echo -n "value" | openssl sha1 -hmac "key" submission*.zip