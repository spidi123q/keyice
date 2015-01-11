#include "mainwindow.h"
#include "ui_mainwindow.h"


MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    ui->comboBox_en->addItem("Simple Encryption");
    ui->comboBox_en->addItem("Advanced Encryption");
    ui->lineEdit_en->setDisabled(true);
    ui->comboBox_de->addItem("Simple Decryption");
    ui->comboBox_de->addItem("Advanced Decryption");

}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_enButton_clicked()
{
    QString qToencry = ui->inTextEdit_en->toPlainText();
    string Toencry = qToencry.toStdString();
    string encry = "";
    QString qEncry;

    if(ui->comboBox_en->currentText()=="Advanced Encryption")
    {
        long int key;
        myString.keyGen(key);
        myString.keyEncrypt(Toencry,key,encry);
        qEncry = QString::fromStdString(encry);

        QString enkey=QString::number(key);
        ui->lineEdit_en->setText(enkey);
        ui->outTextEdit_en->setPlainText(qEncry);
    }
    else
    {
    myString.simpleEncrypt(Toencry,encry);
     qEncry = QString::fromStdString(encry);
    ui->outTextEdit_en->setPlainText(qEncry);
    }
}

void MainWindow::on_comboBox_en_currentIndexChanged(const QString &arg1)
{
    ui->lineEdit_en->setDisabled(false);
    if(arg1== "Simple Encryption" )
    {
        ui->lineEdit_en->setDisabled(true);
    }
}

void MainWindow::on_deButton_2_clicked()
{
    QString qTodecry = ui->inTextEdit_de->toPlainText();
    string Todecry = qTodecry.toStdString();
    string decry = "";
    QString qDecry;

    if(ui->comboBox_de->currentText()=="Advanced Decryption")
    {
        long int key;
        QString dekey=ui->lineEdit_de->text();

        myString.keyGen(key);

        bool ok;
        key = dekey.toLong(&ok,10);


        myString.keyDecrypt(Todecry,key,decry);
        qDecry = QString::fromStdString(decry);
        ui->outTextEdit_de->setPlainText(qDecry);






    }
    else
    {
      myString.simpleDecrypt(Todecry,decry);
      qDecry = QString::fromStdString(decry);
      ui->outTextEdit_de->setPlainText(qDecry);
    }

}

void MainWindow::on_comboBox_de_currentIndexChanged(const QString &arg1)
{
    ui->lineEdit_de->setDisabled(false);
    if(arg1== "Simple Decryption" )
    {
        ui->lineEdit_de->setDisabled(true);
    }
}

void MainWindow::on_pushButton_2_clicked()
{


  myAbout.setModal(true);
  myAbout.show();
  myAbout.exec();
}

void MainWindow::on_pushButton_clicked()
{
    myAbout.setModal(true);
    myAbout.show();
    myAbout.exec();

}
