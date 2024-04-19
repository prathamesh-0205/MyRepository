#include<iostream>
using namespace std;

class date
{
    int dd,mm,yy;
    public:
    date()
    {
        dd=10;
        mm=10;
        yy=2024;
    }
    date(int dd,int mm,int yy)
    {
        this->dd=dd;
        this->mm=mm;
        this->yy=yy;
    }
    void displaydate()
    {
        cout<<dd<<"/"<<mm<<"/"<<yy<<endl;
    }
    void acceptdate()
    {
        cout<<"enter dd mm yyyy:"<<endl;
        cin>>dd>>mm>>yy;
    }


};
int main(void)
{
    date d1;
    d1.acceptdate();
    d1.displaydate();
    cout<<"----"<<endl;
    date d2(d1);
    //d1.displaydate();
    d2.displaydate();
  

}