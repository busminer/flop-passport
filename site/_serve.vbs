' Serve the built site on 8125, detached from whatever started it and with no console
' window. A shell started from the agent session dies with the session; this does not.
Set sh = CreateObject("WScript.Shell")
sh.CurrentDirectory = "C:\floop\site"
sh.Run "cmd /c python -m http.server 8125 --bind 127.0.0.1", 0, False
