"""No-op stand-in for POSIX fcntl so Technocore's server can run on Windows.

Only used by our single-process local test harness. store.py takes an exclusive flock
around one append; with exactly one uvicorn worker and one test client there is no second
writer to exclude, so the lock is not doing work here. This shim exists in our tests
directory and never touches the upstream checkout.
"""
LOCK_EX = 2
LOCK_UN = 8
LOCK_SH = 1
LOCK_NB = 4


def flock(fd, operation):
    return None


def lockf(fd, operation, length=0, start=0, whence=0):
    return None


def fcntl(fd, op, arg=0):
    return 0


def ioctl(fd, request, arg=0, mutate_flag=True):
    return 0
