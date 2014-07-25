#/bin/sh

if [ -f submission.zip ]; then
	rm submission.zip
fi
if [ -f submission.zip ];then
	rm submission.zip
fi

zip submission README code solution
# openssl sha1 submission.zip
echo -n "value" | openssl sha1 -hmac "key" submission.zip