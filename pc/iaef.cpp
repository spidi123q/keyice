#include "iaef.h"
#include <QMessageBox>

IAEF::IAEF()
{
}

void IAEF::simpleEncrypt(string toEncry, string& output)
{

    int charNum = 0;
    string text="";

    for(int i=0;i<toEncry.length();i++)
    {
        charNum = int(toEncry[i]);
        charNum=charNum+1;
        text+=char(charNum);
    }
        output=text;
}



void IAEF::simpleDecrypt(string toDecry, string &output)
{

    int charNum = 0;
     string text="";

    for(int i=0;i<toDecry.length();i++)
    {
        charNum = int(toDecry[i]);
        charNum=charNum-1;
        text+=char(charNum);
    }
        output=text;

}


void IAEF::keyGen(long int &key)
{
    srand(time(0));

    start:

    long int keyCode = rand();
    int random = keyCode % (1 - 10);
    if(random==0) goto start;
     key=keyCode;
}

void IAEF::keyEncrypt(string toEncry, long int key, string &encrypted)
{
    int keyCode = key % (1 - 10);

    int charNum = 0;
    string text = "";

      for(int i=0;i<toEncry.length();i++)
      {
          charNum = int(toEncry[i]);
          charNum=(charNum + keyCode);


          text+=char(charNum);
      }
      encrypted = text;

}


void IAEF::keyDecrypt(string toDecry, long int key, string &decrypted)
{


    int keyCode = key % (1 - 10);

    int charNum = 0;
    string text = "";

      for(int i=0;i<toDecry.length();i++)
      {
          charNum = int(toDecry[i]);
          charNum=(charNum - keyCode);


          text+=char(charNum);
      }
      decrypted = text;


}

