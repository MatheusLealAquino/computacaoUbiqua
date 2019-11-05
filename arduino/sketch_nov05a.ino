#include <Javino.h>


void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600); //INICIALIZA A SERIAL
  #define LUZ    A0 //Sensor de luz no A0
  #define TEMP   A1 //Sensor de luz no A0
  pinMode(LUZ, INPUT); //Configura o pino A0 como entrada
  pinMode(TEMP, INPUT); //Configura o pino A1 como entrada
}

Javino j;

void loop() {
  // put your main code here, to run repeatedly:
int LUMINOSIDADE = analogRead(LUZ); // e le o valor da luminosidade
int TEMPERATURA = (float(analogRead(TEMP))*5/(1023))/0.01; // e le o valor da luminosidade
String s = "L";
s=s+ LUMINOSIDADE;
j.sendmsg(s);
s="T";
s=s+TEMPERATURA;
j.sendmsg(s);
delay(500);
}
