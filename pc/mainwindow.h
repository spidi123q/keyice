#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include "iaef.h"
#include "about.h"

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT
    
public:
    explicit MainWindow(QWidget *parent = 0);
    IAEF myString;
    About myAbout;

    ~MainWindow();
    
private slots:
    void on_enButton_clicked();

    void on_comboBox_en_currentIndexChanged(const QString &arg1);

    void on_deButton_2_clicked();

    void on_comboBox_de_currentIndexChanged(const QString &arg1);

    void on_pushButton_2_clicked();

    void on_pushButton_clicked();



private:
    Ui::MainWindow *ui;
};

#endif // MAINWINDOW_H
