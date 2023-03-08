fruits = {"apple" : 100, "orange" : 60, "banana" : 40, "avocado" : 120}

find = input("Enter the fruit to be searched: ")

if find.lower() in fruits.keys():
    print(find + " Found!")
else:
    print("Not found!")