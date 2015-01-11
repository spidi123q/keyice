#-------------------------------------------------
#
# Project created by QtCreator 2013-09-22T14:43:32
#
#-------------------------------------------------

QT       += core gui

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

TARGET = keyice
TEMPLATE = app


SOURCES += main.cpp\
        mainwindow.cpp \
    iaef.cpp \
    about.cpp

HEADERS  += mainwindow.h \
    iaef.h \
    about.h

FORMS    += mainwindow.ui \
    about.ui

RESOURCES += \
    resource.qrc
 RC_FILE = myapp.rc

 ICON = myapp.icns
