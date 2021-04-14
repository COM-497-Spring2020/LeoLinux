#!/bin/sh

echo "DELETE USER SEQUENCE"
echo " "

read -p "Name of User To Delete: " name
echo " "

read -p "Are You Sure (Y/N)?: " check

if [ $check == 'Y' ]
then
	sudo userdel $name --remove
else
	echo " "
	echo "User $name NOT Deleted"
fi

echo " "
echo "Have a nice day!"
