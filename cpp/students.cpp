#include<iostream>
#include<string.h>
#include<fstream>

using namespace std;

class student
{
    public:
    int roll_no;
    char name[20];
    char city[20];

    void accept_details(int roll_no,char* nm,char* cty)
    {
        this->roll_no=roll_no;
        strcpy(this->name,nm);
        strcpy(this->city,cty);
    }
    void display_detail()
    {
        cout<<"\t Roll No=" << this->roll_no << "\t name=" << this->name << "\t City=" << this->city << endl;

    }
    bool find_student(student &obj,int rollno)
    {
        if(obj.roll_no=rollno)
        return 1;
        else 
        return 0;
    }
};
void writestudents(string filename,student &obj)
{
    ofstream output(filename,ios::binary | ios::app);
    output.write((char*)&obj,sizeof(student));
    cout<<"------data added in file-------"<<endl;
    output.close();
}
void readALLstudents(string filename)
{
    student s1;
    ifstream input(filename,ios::in | ios::binary);

    while (input.read((char*)&s1,sizeof(student)))
    {
       // s1.display_detail();
       // input.read((char*)&s1,sizeof(student));
        s1.display_detail();

    }
    input.close();
}

void readSINGLEstudent(string filename)
{
    student s1;
    ifstream input(filename,ios::in | ios::binary);

    while(input.read((char*)&s1,sizeof(student)))
    {
        //input.read((char*)&s1,sizeof(student));
        s1.display_detail();
        break;


    }
    input.close();

}
void readUSINGROLLNOstudent(string filename,int roll_no)
{
    student s1;
    ifstream input(filename,ios::binary);
    input.read((char*)&s1,sizeof(student));

    while(!input.eof())
    {
        if(s1.find_student(s1,roll_no))
        {
            cout<<"yes";
            s1.display_detail();
            break;
        }
         input.read((char*)&s1,sizeof(student));
    }
    input.close();
}
int main()
{
    student s2;
    int ch;
    char nm[20],cty[20];
    int rollno;
    string filename;
    cout<<"enter file name:"<<endl;
    cin>>filename;

    do
    {
        cout<<" 1.add_details \n 2.display_details \n 3.add_in_file \n 4.read_ALL \n 5.search_ROLLNO \n 6.read_single_detail:"<<endl;  
        cout<<"enter your choice:"<<endl;
        cin>>ch;

        switch(ch)
        {
            case 1:
            cout<<"enter data"<<endl;
            cout<<"enter roll_no,name,city"<<endl;
            cin>>rollno>>nm>>cty;
            s2.accept_details(rollno,nm,cty);

            break;

            case 2:
            s2.display_detail();
            break;

            case 3:
            int cntnue;
            cout<<"if you want to change file press 1 otherwise press any no:"<<endl;
            cin>>cntnue;

            if(cntnue==1)
            {
                cout<<"enter file name:"<<endl;
                cin>>filename;
            }
            writestudents(filename,s2);
            break;

            case 4:
            cout<<"if you want to change file press 1 otherwise press any no:"<<endl;
            cin>>cntnue;

            if(cntnue==1)
            {
                cout<<"enter file name:"<<endl;
                cin>>filename;
            }
            cout<<"----reading students data----"<<endl;
            readALLstudents(filename);
            break;

            case 5:
            int rollno;

            cout << "Enter Student Roll no" << endl;
            cin >> rollno;
            readUSINGROLLNOstudent(filename, rollno);
            break;

            case 6:
            readSINGLEstudent(filename);
            break;



            case 0:
            cout << "Application Terminated !" << endl;
            break;

            default:
            cout << "invalid choice!" << endl;
            break;





        }    
    } while (ch!=0);
    
}