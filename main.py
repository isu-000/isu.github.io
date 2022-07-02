import pyautogui
import time
a=0
time.sleep(5)
while a<=2000:
    pyautogui.mouseDown(); pyautogui.mouseUp() 
    pyautogui.hotkey('ctrl','v')
    time.sleep(1)
    pyautogui.press('enter', presses=5)
    a=a+1
