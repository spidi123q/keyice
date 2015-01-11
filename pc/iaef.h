#ifndef IAEF_H
#define IAEF_H
#include <iostream>
#include<stdio.h>
#include <string>
#include<ctime>
#include<cstdlib>
using namespace std;

class IAEF
{
public:
    IAEF();
    void simpleEncrypt(string toEncry,string& output );
    void simpleDecrypt(string toDecry,string& output);


    void keyGen(long int &key);
    void keyEncrypt(string toEncry,long int key,string& encrypted);
    void keyDecrypt(string toDecry,long int key,string& decrypted);


};

#endif // IAEF_H
