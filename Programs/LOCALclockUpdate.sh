#!/bin/sh

echo "SET LOCAL TIME SEQUENCE"

if [ -e /etc/adjtime ]
then
	#echo "File EXISTS!"
	echo ""
else
	#echo "File does NOT EXIST!"
	sudo hwclock -w
	sed -i 's/UTC/LOCAL/g' /etc/adjtime
	echo ""
fi

echo "Examples:"
echo "10:15:03AM"
echo "7:20:20PM"
echo " "

read -p "PLEASE ENTER TIME (HH:MM:SS(AM/PM)): " time
echo "Time is: $time"

date +%T -s "$time"
