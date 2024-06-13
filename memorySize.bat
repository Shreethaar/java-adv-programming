@echo off
setlocal EnableDelayedExpansion

REM Run systeminfo and filter for Total Physical Memory
for /f "tokens=*" %%a in ('systeminfo ^| findstr /i /c:"Total Physical Memory"') do (
    set "memoryInfo=%%a"
    set "memorySize=!memoryInfo:*: =!"
    set "memorySizeWithoutUnit=!memorySize:~0,-2!"
)

echo Total Physical Memory: !memoryInfo! > memory_info.txt
echo Memory Size: !memorySizeWithoutUnit! >> memory_info.txt

endlocal
