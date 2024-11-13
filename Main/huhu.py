def add(x,y):
  return x+y
def divide (x,y):
  if x ==0 or y ==0:
    print("YOU CANT DIVIDE BY ZERO")
  else:
    return x/y


print("SELECT OPERATION")
print("1. ADD")
print("2. SUBTRACTION")
print("3. MULTIPLICATION")
print("4. DIVISION")

while True:
  choice1 = input("ENTER CHOICE(1|2|3|4): ")
  #check if choice is one of the 4 option
  if choice1 in ('1', '2', '3', '4'):
    num1 = float(input("ENTER FIRST NUMBER: "))
    num2 = float(input("ENTER SECOND NUMBER: "))

    if choice1 == '1':