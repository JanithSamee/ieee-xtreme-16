def get_number():
	return float(input())

testCases = get_number()

for i in range(testCases):
    length = get_word()
    length = int(length)
    if(length == 0):
        print(1)
    else:
        angles = []
        for i in range(length):
            element = get_word()
            angles.append(element)
        anglesCut = []
        for i in angles:
            i = int(i)
            if i<0: i *= -1
            rotations = i//360
            i  = i - 360*rotations
            if i >= 180: i -= 180
            if i in anglesCut: continue
            else: anglesCut.append(i)
        print(len(anglesCut)*2)