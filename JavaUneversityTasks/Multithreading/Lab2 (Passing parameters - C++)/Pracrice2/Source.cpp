#include <iostream>
#include <thread>
#include <mutex>

using namespace std;

#define C 8; // constant

// Task 1

void runTask1(int num) {
	this_thread::sleep_for(chrono::milliseconds(2000));
	cout << "Thraed " << this_thread::get_id() << " star calculating..." << endl;
	this_thread::sleep_for(chrono::milliseconds(2000));
	cout << "Thraed " << this_thread::get_id() << " end calculate" << endl;
	cout << num * C;
	cout << endl;
}

// Task 3 & 4
int runTask3(int num) {
	this_thread::sleep_for(chrono::milliseconds(2000));
	cout << "Thraed " << this_thread::get_id() << " star calculating..." << endl;
	this_thread::sleep_for(chrono::milliseconds(2000));
	cout << "Thraed " << this_thread::get_id() << " end calculate" << endl;
	return num * C;
}

int main() {
	// Task 2
	int num = 3;
	thread th2 (runTask1, ref(num));
	th2.join();
	thread th3 (runTask1, ref(num));
	th3.detach();
	thread th4 (runTask1, ref(num));
	th4.join();

	// Task 3 & 4
	int res;
	thread th1([&res]() {res = runTask3(2); });
	th1.join();
	cout << res << endl;


	return 0;
}