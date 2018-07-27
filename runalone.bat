cd app/build/outputs/apk/debug
adb push ./app-debug.apk /data/local/tmp/com.hsae.belus
adb shell pm install -t -r "/data/local/tmp/com.hsae.belus"
adb shell am startservice -n com.hsae.belus/.AutoService
cd ../../../../../