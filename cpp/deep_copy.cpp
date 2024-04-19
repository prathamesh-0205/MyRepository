#include<iostream>
using namespace std;
 class box
 {
    private:int length;
    int *breadth;
    int height;
    public:
    box()
    {
        cout<<"---box default---"<<endl;
    }
    box(int l,int b,int h)
    {
        this->length=l;
        this->breadth=new int;
        *this->breadth=b;
        this->height=h;
    }
    void accept()
    {
        cout<<"enter l,b,h";
        cin>>length>>*breadth>>height;

    }
    void dispaly()
    {
        cout<<"LENGTH: "<<length<<" BREADTH: "<<*breadth<<" HEIGHT: "<<height<<endl;

    }
    void setbreadth(int b)
    {
        *breadth=b;
    }
    box(const box &b1obj)
    {
        this->length=b1obj.length;
        this->breadth=new int;
        *breadth=*b1obj.breadth;
        this->height=b1obj.height;

    }
    ~box()
    {
        cout<<"destructor"<<endl;
        delete breadth;
        cout<<"memory deleted from heap"<<endl;

    }




 };
 int main()
 {
    box b1(10,20,30);
    b1.dispaly();
    cout<<"after copy:"<<endl;
    box b2(b1);
    b2.dispaly();

    b1.setbreadth(90);
    b1.dispaly();
    b2.dispaly();
    
 }