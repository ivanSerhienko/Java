#include <iostream>
#include <thread>
#include <string>
#include <mutex>
#include <stdlib.h>
#include <cstdlib>
#include <ctime>

using namespace std;

// Task 1
class Test {

public: 
	static void run(string threadName) {
		for (int i = 0; i < 10; i++) {
			string out = threadName + " " + to_string(i) + "\n";
			cout << this_thread::get_id() << " \t" + out;
		}
	}
public:
	static int multiplying (int num1, int num2) {
		this_thread::sleep_for(chrono::milliseconds(1000));
		cout << "Thraed " << this_thread::get_id() << " star calculating..." << endl;
		this_thread::sleep_for(chrono::milliseconds(1000));
		cout << "Thraed " << this_thread::get_id() << " end calculate" << endl;
		return num1 * num2;
	}
};

template<typename T>

// Task 2
class Vector
{
private:
    T* data = new T[2];
    int  size = 0;
    int  capacity = 2;
public:
    Vector() {} // конструктор по умолчанию

    Vector(int capacity) { resize(capacity); }

    Vector(const Vector<T>& other)   // конструктор
    {
        this->data = other.data;
        this->capacity = other.capacity;
        this->size = other.size;
    }

    ~Vector() { delete[] data; } // деструктор

    void clear()
    {
        for (int i = 0; i < size; i++)
            data[i] = 0;
        size = 0;
    }

    void resize(int new_capacity)
    {
        T* buf = new T[new_capacity];

        if (new_capacity < size)
            size = new_capacity;

        for (int i = 0; i < size; i++)
            buf[i] = data[i];

        delete[] data;
        data = buf;
        capacity = new_capacity;
    }

    int GetSize() { return size; }

    int GetCapacity() { return capacity; }

    bool operator+(Vector<T>& other)
    {
        return this->data + other.data;
    }

    T& operator[] (int index)  //
    {

        //if (index > Vector::GetSize())
        //{
        //    cout << "Error";
        //    break;
        //}

        try
        {
            index > Vector::GetSize();
        }
        catch (const char* exc)
        {
            cerr << "Error" << exc << endl;
        }

        return data[index];
    }

    bool operator==(Vector<T>& other) { return data == *other.data && size == other.size; } //

    T& at(int index) { return data[index]; }

    void push_back(T value)
    {
        if (size >= capacity)
            resize(capacity * 2);

        data[size] = value;
        size++;
    }

    void push_front(T value) { insert(0, value); }

    void insert(int index, T value)
    {
        if (size >= capacity)
            resize(capacity * 2);

        for (int i = size; i > index; i--)
            data[i] = data[i - 1];

        data[index] = value;
        size++;
    }

    void erase(int index) { erase(index, 1); }

    void erase(int index, int count)
    {
        if (index > capacity)
            return;

        for (int i = index; i < size - count; i++)
            data[i] = data[i + count];

        size -= count;
    }

    T& back() { return data[size - 1]; }

    T& begin() { return data[0]; }
};

// Task 3

struct t2node
{
    int info;
    t2node* prev;
    t2node* next;
};
typedef t2node* p2node;

// functions with mutex
mutex mtx;

void headFormM(p2node& head, p2node& tail, p2node& cur) // функия формирования списка с головы 
{
    mtx.lock();
    int info = rand() % 20;

    if (info)//формируем голову
    {
        head = new t2node;
        head->info = info;
        head->prev = NULL;
    }

    info = rand() % 20;
    cur = head;

    for (int i = 0; i < 10; i++) // подвязуем все елементы к head
    {
        cur->next = new t2node;
        cur->next->prev = cur; // что бы следуйщий елемент указывал на предыдущий 
        cur = cur->next;
        cur->info = info;
        info = rand() % 20;
    }

    //формируем хвост
    cur->next = NULL;
    tail = cur;
    mtx.unlock();
}

void printHeadM(p2node head) // вывод с головы
{
    mtx.lock();
    p2node cur;
    cur = head;

    while (cur)
    {
        cout << cur->info << " ";
        cur = cur->next;
    }
    mtx.unlock();
}

int deleteNodeM(p2node* head, p2node* tail, int num)
{
    mtx.lock();

    p2node cur = NULL;

    if (!(*head))// проверяется список (он пустой или нет)
    {
        cout << "Please enter a list";
        return 0;
    }

    if ((*head)->info == num) //проверяется элемент (он первый или нет)
    {
        cur = *head;
        *head = (*head)->next;
        delete cur;
        return 1;
    }

    if ((*tail)->info == num) //проверяется элемент (он последний или нет)
    {
        cur = *tail;
        *tail = (*tail)->prev;
        (*tail)->next = NULL;
        delete cur;
        return 1;
    }

    else // ишем заданный элемент
    {
        cur = *head;
        while (cur)
        {
            if (cur->info == num)
            {
                cur->prev->next = cur->next;
                cur->next->prev = cur->prev;
                delete cur;
                return 1;
            }
            else
                cur = cur->next;
        }
    }

    cout << "The specified element was not found" << endl;

    mtx.unlock();
    return 0;
}

int insertAfterM(p2node* head, p2node* tail, int num, int newNum)
{
    mtx.lock();
    p2node cur, newNode;

    if (!(*head))// проверяется список (он пустой или нет)
    {
        cout << "Please enter a list";
        return 0;
    }

    if ((*tail)->info == num) //проверяется элемент (он первый или нет)
    {
        cur = new t2node;
        cur->info = newNum;
        cur->next = NULL;
        (*tail)->next = cur;
        cur->next = NULL;
        *tail = cur;
        return 1;
    }
    else // ищем заданный элемент
    {
        cur = *head;
        while (cur)
        {
            if (cur->info == num)
            {// выдиляем элемент
                newNode = new t2node;
                newNode->info = newNum;
                newNode->next = cur->next; // подвязываем новую ноду к следуйщему элементу 
                newNode->prev = cur;       // подвязываем ковую ноду к текущему элементу
                cur->next->prev = newNode; // подвязываем следуйщий элементу к новой ноде
                cur->next = newNode;       // подвязываем текуйщий эелемент к новой ноде
                return 1;
            }
            else
                cur = cur->next;
        }
    }
    cout << "The specified element was not found" << endl;
    mtx.unlock();
    return 0;
}

int amountElM(p2node& head, p2node& tail) {
    mtx.lock();

    int amount = 0;
    p2node cur;
    cur = head;
    while (cur) {
        cur = cur->next;
        amount++;
    }
    return amount;

    mtx.unlock();
}

// functions without mutex

void headForm(p2node& head, p2node& tail, p2node& cur) // функия формирования списка с головы 
{
    int info = rand() % 20;

    if (info)//формируем голову
    {
        head = new t2node;
        head->info = info;
        head->prev = NULL;
    }

    info = rand() % 20;
    cur = head;

    for (int i = 0; i < 10; i++) // подвязуем все елементы к head
    {
        cur->next = new t2node;
        cur->next->prev = cur; // что бы следуйщий елемент указывал на предыдущий 
        cur = cur->next;
        cur->info = info;
        info = rand() % 20;
    }

    //формируем хвост
    cur->next = NULL;
    tail = cur;
}

void printHead(p2node head) // вывод с головы
{
    p2node cur;
    cur = head;

    while (cur)
    {
        cout << cur->info << " ";
        cur = cur->next;
    }
}

int deleteNode(p2node* head, p2node* tail, int num)
{
    p2node cur = NULL;

    if (!(*head))// проверяется список (он пустой или нет)
    {
        cout << "Please enter a list";
        return 0;
    }

    if ((*head)->info == num) //проверяется элемент (он первый или нет)
    {
        cur = *head;
        *head = (*head)->next;
        delete cur;
        return 1;
    }

    if ((*tail)->info == num) //проверяется элемент (он последний или нет)
    {
        cur = *tail;
        *tail = (*tail)->prev;
        (*tail)->next = NULL;
        delete cur;
        return 1;
    }

    else // ишем заданный элемент
    {
        cur = *head;
        while (cur)
        {
            if (cur->info == num)
            {
                cur->prev->next = cur->next;
                cur->next->prev = cur->prev;
                delete cur;
                return 1;
            }
            else
                cur = cur->next;
        }
    }

    cout << "The specified element was not found" << endl;
    return 0;
}

int insertAfter(p2node* head, p2node* tail, int num, int newNum)
{
    p2node cur, newNode;

    if (!(*head))// проверяется список (он пустой или нет)
    {
        cout << "Please enter a list";
        return 0;
    }

    if ((*tail)->info == num) //проверяется элемент (он первый или нет)
    {
        cur = new t2node;
        cur->info = newNum;
        cur->next = NULL;
        (*tail)->next = cur;
        cur->next = NULL;
        *tail = cur;
        return 1;
    }
    else // ищем заданный элемент
    {
        cur = *head;
        while (cur)
        {
            if (cur->info == num)
            {// выдиляем элемент
                newNode = new t2node;
                newNode->info = newNum;
                newNode->next = cur->next; // подвязываем новую ноду к следуйщему элементу 
                newNode->prev = cur;       // подвязываем ковую ноду к текущему элементу
                cur->next->prev = newNode; // подвязываем следуйщий элементу к новой ноде
                cur->next = newNode;       // подвязываем текуйщий эелемент к новой ноде
                return 1;
            }
            else
                cur = cur->next;
        }
    }
    cout << "The specified element was not found" << endl;
    return 0;
}

int amountEl(p2node& head, p2node& tail) {
    int amount = 0;
    p2node cur;
    cur = head;
    while (cur) {
        cur = cur->next;
        amount++;
    }
    return amount;
}

int main() {
	// Task 1
	int res;

	for (int i = 0; i < 10; i++) {
		this_thread::sleep_for(chrono::milliseconds(500));
		thread th1([&res]() { Test::run("Thread one"); res = Test::multiplying(3, 2); });
		th1.join();
		cout << res << endl;
		thread th2([&res]() { Test::run("Thread two"); res = Test::multiplying(3, 3); });
		th2.join();
		cout << res << endl;
	}

    // Task 2
    Vector <int> v;
    Vector <int> k;

    thread th3([&v]() {
        v.push_back(5);
        v.push_back(4);
        v.push_back(3);
        v.push_back(2);
        v.push_back(1);

        for (int i = 0; i < v.GetSize(); i++)
            cout << v[i] << " ";
        cout << endl; 
        }
    );

    thread th4([&k]() {
        k.push_back(5);
        k.push_back(4);
        k.push_back(3);
        k.push_back(2);
        k.push_back(1);

        for (int i = 0; i < k.GetSize(); i++)
            cout << k[i] << " ";
        cout << endl;
        }
    );

    th3.join();

    th4.join();

    // Task 3

    p2node head = NULL;
    p2node cur = NULL;
    p2node tail = NULL;

    thread List1([&]() {
        headForm(head, tail, cur);
        printHead(head);
        cout << endl;
        cout << amountEl(head, tail) << endl;
        }
    );

    thread List2([&]() {
        headForm(head, tail, cur);
        printHead(head);
        cout << endl;
        cout << amountEl(head, tail) << endl;
        }
    );

    thread List1M([&]() {
        headFormM(head, tail, cur);
        printHeadM(head);
        cout << endl;
        cout << amountElM(head, tail) << endl;
        }
    );

    thread List2M([&]() {
        headFormM(head, tail, cur);
        printHeadM(head);
        cout << endl;
        cout << amountElM(head, tail) << endl;
        }
    );

    List1.join();
    List2.join();

    List1M.join();
    List2M.join();
	return 0;
}