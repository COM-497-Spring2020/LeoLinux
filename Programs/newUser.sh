#!/bin/sh

echo "NEW USER SEQUENCE"
echo " "

read -p "Name of New User (lowercase please): " name
echo "New User: $name"
echo " "

sudo useradd $name
sudo usermod -aG sudo $name

read -p "Do You Want to Add a Password for $name (Y/N)?" passwordQ
echo " "

if [ $passwordQ == "Y" ]
then
	echo "Password for $name: "
	sudo passwd $name
	echo " "
else
	echo "Setting User \"$name\" Without Password"
	sudo passwd -d -u $name
	echo " "
fi

echo "SETTING HOME DIRECTORIES"
#home = "/home/$name"
export XDG_DESKTOP_DIR="/home/$name/Desktop"
export XDG_DOWNLOAD_DIR="/home/$name/Downloads"
export XDG_TEMPLATES_DIR="/home/$name/Templates"
export XDG_PUBLICSHARE_DIR="/home/$name/Public"
export XDG_DOCUMENTS_DIR="/home/$name/Documents"
export XDG_MUSIC_DIR="/home/$name/Music"
export XDG_PICTURES_DIR="/home/$name/Pictures"
export XDG_VIDEOS_DIR="/home/$name/Videos"

mkdir /home/$name/Desktop
mkdir /home/$name/Downloads
mkdir /home/$name/Templates
mkdir /home/$name/Public
mkdir /home/$name/Documents
mkdir /home/$name/Music
mkdir /home/$name/Pictures
mkdir /home/$name/Videos

echo " "


echo "NEW USER $name CREATED SUCCESSFULLY"

