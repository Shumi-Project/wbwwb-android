#!/usr/bin/env bash
trap "exit" INT
set -e

echo "Checking if there's adb devices connected..."
if adb get-state 1>/dev/null 2>&1
then
  echo "Device connected!"
  DEVICE_INFO=$(adb shell getprop ro.vendor.product.model)
  echo Model: $DEVICE_INFO
  echo "Building APK..."
  ./gradlew assembleDebug --info
  echo "Installing APK..."
  adb install -r ./app/build/outputs/apk/debug/wbwwb-android.apk
  echo "APK Installed! Starting app..."
  adb shell am start -n com.shumiproject.wbwwb/com.shumiproject.wbwwb.MainActivity
else
  echo "There's no device connected. Exiting..."
  exit 1
fi
