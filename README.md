# DS-ALGO-Java-
DS-ALGO

1. **Recursion**
     - Basic Recursion
	    - Print Names N times. [[code]](https://github.com/anchitbhuhan/DS-ALGO-Java-/blob/main/Recursion/printNtimes.cpp)
	    - Print 1 to N. [[code]](https://github.com/anchitbhuhan/DS-ALGO-Java-/blob/main/Recursion/OnetoN.cpp)
	    - Print N to 1. [[code]](https://github.com/anchitbhuhan/DS-ALGO-Java-/blob/main/Recursion/printNtimes.cpp)
	    - Sum of First N numbers. [[code]](https://github.com/anchitbhuhan/DS-ALGO-Java-/tree/main/Recursion)
	    - Factorial of N. [[code]](https://github.com/anchitbhuhan/DS-ALGO-Java-/blob/main/Recursion/Factorial.cpp)
	    - Print Reverse of Arrat. [[code]](https://github.com/anchitbhuhan/DS-ALGO-Java-/blob/main/Recursion/PrintReverse.cpp)
2. **Array as ADT**
/*
  NRF24 TRANSMITTER CODE BY ARCHIT BUBBER
  Use pin 9,10 for Nrf
  This code uses a buzzer for alerting connection lost and sticks values initialization/
  Alternatively you can use Serial Monitor for debugging by uncommenting the lines.
  Enjoy Flying
*/
#include <SPI.h>
#include <nRF24L01.h>
#include <RF24.h>

const byte slaveAddress[5] = {'R', 'x', 'A', 'A', 'A'};

RF24 radio(4, 3);

struct MyData {
  int throttle;
  int yaw;
  int pitch;
  int roll;
  int AUX1;
  int AUX2;
  int AUX3;
};
int l[6], m[6], h[6]; //600-1620
MyData data;
void calibrate() {
  digitalWrite(8, HIGH);
  delay(1000);
  digitalWrite(8, LOW);
  Serial.println("middle values");
  for (int i = 1; i < 5; i++) {
    m[i] = analogRead(i);
  }
  delay(1000);
  digitalWrite(8, HIGH);
  delay(3000);
  digitalWrite(8, LOW);
  Serial.println("high values");
  for (int i = 1; i < 5; i++) {
    h[i] = analogRead(i);
  }
  delay(1000);
  digitalWrite(8, HIGH);
  delay(3000);
  digitalWrite(8, LOW);
  Serial.println("lower values");
  for (int i = 1; i < 5; i++) {
    l[i] = analogRead(i);
  }
  digitalWrite(8, HIGH);
  delay(200);
  digitalWrite(8, LOW);
  delay(500);
  digitalWrite(8, HIGH);
  delay(200);
  digitalWrite(8, LOW);
}
void resetData()
{
  data.throttle = 0;
  data.yaw = 127;
  data.pitch = 127;
  data.roll = 127;
  data.AUX1 = 0;
  data.AUX2 = 0;
  data.AUX3 = 0;
}
void radio_setup() {
  radio.begin();
  if (radio.isChipConnected ()) {
    radio.setDataRate( RF24_250KBPS );
    radio.setPALevel(RF24_PA_MAX);
    radio.setChannel(69);
    //radio.enableAckPayload();
    //radio.setRetries(3,5); // delay, count
    radio.openWritingPipe(slaveAddress);
  }
  else {
    while (!radio.isChipConnected ()) {
      Serial.println("Make proper connections"); //no radio inserted or bad connection
      digitalWrite(8, HIGH);
      delay(200);
      digitalWrite(8, LOW);
      delay(200);
    }
  }

}
int mapJoystickValues(int val, int lower, int middle, int upper, bool reverse)
{
  if (val > middle - 20 && val < middle + 20)
  {
    return 1502;
  }
  else if ( val < middle )
    val = map(val, lower, middle, 1004, 1502);
  else
    val = map(val, middle, upper, 1502, 2004);
  return ( reverse ? 2002 - val : val );
}

void setup() {
  // put your setup code here, to run once:
  pinMode(8, OUTPUT);
  Serial.begin(9600);
  radio_setup();
  //calibrate();
  resetData();
}
byte ack;
void loop() {
  if (radio.isChipConnected ()) {
    send_nrf();
  }
  else {
    Serial.println("Make Proper Connections");
    digitalWrite(8, HIGH);
    delay(200);
    digitalWrite(8, LOW);
    delay(200);

  }

}
void send_nrf() {
//  data.throttle = mapJoystickValues( analogRead(A1),  l[4], m[4], h[4], false);
//  data.yaw      = mapJoystickValues( analogRead(A0),   l[3], m[3], h[3], false);
//  data.pitch    = mapJoystickValues( analogRead(A3),  l[2], m[2], h[2], false);
//  data.roll     = mapJoystickValues( analogRead(A3), l[1], m[1], h[1], false);
  data.throttle = analogRead(A1);
  data.yaw      = analogRead(A0);
  data.pitch    = analogRead(A3);
  data.roll     = analogRead(A2);
//  data.AUX1 = map(analogRead(5), 0, 1023, 1000, 2000);
//  data.AUX2 = map(analogRead(0), 0, 1023, 1000, 2000);
  Serial.print("throttle-");
    Serial.print(data.throttle);
    Serial.print(" ");
    Serial.print("yaw-");
    Serial.print(data.yaw);
    Serial.print(" ");
    Serial.print("pitch-");
    Serial.print(data.pitch);
    Serial.print(" ");
    Serial.print("roll-");
    Serial.print(data.roll);
    Serial.println();
//    Serial.print(data.AUX1);
//    Serial.print(" ");
//    Serial.print(data.AUX2);
//    Serial.print(" ");  Serial.println(data.AUX3);
    delay(100);
 
  if (radio.write(&data, sizeof(MyData))) {
    //if(radio.isAckPayloadAvailable()){
    // radio.read(&ack, sizeof(ack));
    // Serial.println(ack);
    Serial.println("connected");
    digitalWrite(8, LOW);
  }
  else {

    Serial.println("no ack");
    digitalWrite(8, HIGH);

  }
}

