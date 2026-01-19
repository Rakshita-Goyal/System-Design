#include <iostream>
#include <string>

using namespace std;

class Car {
public:
    virtual void startEngine() = 0;
    virtual void shiftCar(int gear) = 0;
    virtual void brake() = 0;
    virtual void stopEngine() = 0;
    virtual ~Car() {}   // virtual destructor
};

class SportsCar : public Car {
public:
    string brand;
    string model;
    bool isEngine;
    int currentSpeed;
    int currentGear;

    SportsCar(string b, string m) {
        brand = b;
        model = m;
        isEngine = false;
        currentSpeed = 0;
        currentGear = 0;
    }

    void startEngine() override {
        cout << "Engine started\n";
        isEngine = true;
    }

    void shiftCar(int gear) override {
        currentGear = gear;
        cout << "Gear shifted to " << gear << endl;
    }

    void brake() override {
        cout << "Brake applied\n";
    }

    void stopEngine() override {
        cout << "Engine stopped\n";
        isEngine = false;
    }
};

int main() {
    Car* car = new SportsCar("Ford", "Mustang");
    car->startEngine();

    delete car; // VERY important
    return 0;
}
