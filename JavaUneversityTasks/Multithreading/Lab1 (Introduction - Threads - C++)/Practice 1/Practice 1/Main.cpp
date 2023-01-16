//¬се задани€ были показаны и одобрены на паре =).

#include <iostream>
#include <thread>
#include <mutex>
#include <string>
#include <vector>

using namespace std;

mutex mtx;

void fucn1(int* a) {
	//cout << "Hello!" << this_thread::get_id() << endl;
	int c = 0;
	mtx.lock();
	this_thread::sleep_for(1s);
	for (int i = 0; i < 3; i++) {
		a[i] = a[i] + 1;
		c += a[i];
	}
	this_thread::sleep_for(1s);
	cout << "Hello!" << this_thread::get_id() << " Sum  = " << c << endl;
	this_thread::sleep_for(1s);
}

// Task 1
//void run(string threadName)
//{
//	for (int i = 0; i < 10; i++)
//	{
//		string out = threadName + " " + to_string(i) + "\n";
//		cout << this_thread::get_id() << " \t" + out;
//	}
//}

// Task 2.1
//void run1(string threadName, bool flag) {
//	
//	//if (flag) {
//		for (int i = 0; i < 10; i++) {
//			string out = threadName + " " + to_string(i) + " " + to_string(flag) + "" + "\n";
//			cout << this_thread::get_id() << " \t" + out;
//			flag = false;
//		}
//	//}
//}

//void run2(string threadName, bool flag) {
//	if (flag) {
//		for (int i = 0; i < 10; i++) {
//			string out = threadName + " " + to_string(i) + " " + to_string(flag) + "" + "\n";
//			cout << this_thread::get_id() << " \t" + out;
//		}
//	}
//}


// Task 2.2
//void run1(string threadName, bool flag) {
//	
//	for (int i = 0; i < 10; i++) {
//		//if (flag) {
//		string out = threadName + " " + to_string(i) + " " + to_string(flag) + "" + "\n";
//		cout << this_thread::get_id() << " \t" + out;
//		flag = !flag;
//	//}
//	}
	
//}

// Task 3.0

//vector <int> scalarProduct(vector <int> v1, vector <int> v2, vector <int> res) {
//	res.push_back(v1.at(0)*v2.at(0) + v1.at(1)*v2.at(1));
//	return res;
//}

//void scalarProduct(int x1, int x2, int y1, int y2, int res) {
//	res = x1 * x2 + y1 * y2;
//	cout << res << endl;
//}

int main() {

	int a[3];
	for (int i = 0; i < 3; i++)
	{
		a[i] = i;
	}
	thread t1(fucn1, ref(a));
	//thread t2(func1, ref(a));
	thread t2(fucn1, ref(a));
	t1.join();
	t2.join();

	return 0;
	//bool flag = true;

	//vector <int> v1 = vector <int>{1, 2};
	//vector <int> v2 = vector <int>{3, 4};
	//vector <int> res;
	//int x1 = 1;
	//int x2 = 2;
	//int y1 = 3;
	//int y2 = 4;
	//int res = 0;

	//thread th1(scalarProduct, x1, x2, y1, y2, res);
	//thread th2(scalarProduct, x1, x2, y1, y2, res);

	//thread th1(scalarProduct, v1, v2, res);
	//thread th2(scalarProduct, v1, v2, v3);

	//int x1, x2, y1, y2;

	//cout << "Enter the coordinates of the first vector: " << endl;
	//cin >> x1;
	//cin >> y1;
	//cout << endl;
	//cout << "Enter the coordinates of the second vector: " << endl;
	//cin >> x2;
	//cin >> y2;
	//cout << endl;

	//th1.join();
	//th2.join();

	//res = scalarProduct(v1, v2, res);

	//for (int i : res)
	//	cout << i << endl;

	//return 0;
}