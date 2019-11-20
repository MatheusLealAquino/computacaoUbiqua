#include <Javino.h>
#define LUZ    A0 //Sensor de luz no A0
#define TEMP   A1 //Sensor de temperatura no A1

Javino javino;

void setup() {
  Serial.begin(9600); //INICIALIZA A SERIAL
  pinMode(LUZ, INPUT); //Configura o pino A0 como entrada
  pinMode(TEMP, INPUT); //Configura o pino A1 como entrada
}

void loop() {
  int LUMINOSIDADE = analogRead(LUZ); // e le o valor da luminosidade
  int TEMPERATURA = (float(analogRead(TEMP))*5/(1023))/0.01; // e le o valor da luminosidade
  String response = String(LUMINOSIDADE) + ";" + String(TEMPERATURA);
  javino.sendmsg(response); 
  delay(1000);
}
