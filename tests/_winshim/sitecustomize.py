"""Fill in the POSIX-only os calls Technocore's storage engine uses, so the real server
can run on Windows for our local end-to-end test.

Python imports sitecustomize automatically when it is on the path, so this lands before
store.py is imported. Nothing upstream is edited.

os.fchmod tightens permissions on a temp file before an atomic replace. Windows has no
POSIX mode bits to tighten, and the test data lives in a throwaway directory, so a no-op
loses nothing that this harness depends on.
"""
import os

if not hasattr(os, "fchmod"):
    def fchmod(fd, mode):
        return None

    os.fchmod = fchmod

if not hasattr(os, "fchown"):
    def fchown(fd, uid, gid):
        return None

    os.fchown = fchown

if not hasattr(os, "getuid"):
    os.getuid = lambda: 0
    os.getgid = lambda: 0
