import pyautogui
import time
a=0
time.sleep(5)
while a<5:
    #通訊錄
    pyautogui.moveTo(1287,399)
    pyautogui.mouseDown(); pyautogui.mouseUp()
    #聯絡人
    pyautogui.moveTo(1367,402)
    pyautogui.mouseDown(); pyautogui.mouseUp()
    time.sleep(0.25)
    pyautogui.moveTo(1437,832)
    pyautogui.mouseDown(); pyautogui.mouseUp()
    # 輸入標題
    pyautogui.moveTo(1051,437)
    pyautogui.mouseDown(); pyautogui.mouseUp()
    time.sleep(0.25)
    pyautogui.hotkey('ctrl','v')
    # 輸入大綱
    pyautogui.moveTo(985,473)
    pyautogui.mouseDown(); pyautogui.mouseUp()
    time.sleep(0.25)
    pyautogui.hotkey('ctrl','v')
    # 寄出
    pyautogui.moveTo(1285,865)
    pyautogui.mouseDown(); pyautogui.mouseUp()
    a=a+1
 
