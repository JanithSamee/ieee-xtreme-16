def getInput():
    try:
        return int(input())
    except:
        return 0


t = getInput()

for n1 in range(t):
    d = getInput()
    turn=True
    motionList=[
            [" ","o"," "],["/","|","\\"],["/"," ","\\"]
        ]
    for n2 in range(d):
        ins = input()
        insSplited = ins.split(" ")
        if(insSplited[0]=="say"):
            print(ins[4:])
            continue
        elif(insSplited[0]=="turn"):
            
            turn= not turn
            if(motionList[0][0]=="(" and motionList[0][2]==")"):
                pass
            elif(motionList[0][0]=="("):
                motionList[0][0]=" "
                motionList[0][2]=")"
            elif(motionList[0][2]==")"):
                motionList[0][0]="("
                motionList[0][2]=" "

            if(motionList[1][0]==" " and motionList[1][2]=="\\"):
                motionList[1][0]="/"
                motionList[1][2]=" "
            elif(motionList[1][0]==" " and motionList[1][2]==">"):
                motionList[1][0]="<"
                motionList[1][2]=" "
            elif(motionList[1][0]=="/" and motionList[1][2]==" "):
                motionList[1][0]=" "
                motionList[1][2]="\\"
            elif(motionList[1][0]=="/" and motionList[1][2]==">"):
                motionList[1][0]="<"
                motionList[1][2]="\\"
            elif(motionList[1][0]=="<" and motionList[1][2]==" "):
                motionList[1][0]=" "
                motionList[1][2]=">"
            elif(motionList[1][0]=="<" and motionList[1][2]=="\\"):
                motionList[1][0]="/"
                motionList[1][2]=">"

            if(motionList[2][0]=="/" and motionList[2][2]==">"):
                motionList[2][0]="<"
                motionList[2][2]="\\"
            elif(motionList[2][0]=="<" and motionList[2][2]=="\\"):
                motionList[2][0]="/"
                motionList[2][2]=">"
                
        elif((not turn and insSplited[0]=="right")or (turn and insSplited[0]=="left")):
            if(insSplited[1]=="hand"):
                if(insSplited[3]=="head"):
                    motionList[1][2]=" "
                    motionList[0][2]=")"
                elif(insSplited[3]=="hip"):
                    motionList[0][2]=" "
                    motionList[1][2]=">"
                elif(insSplited[3]=="start"):
                    motionList[0][2]=" "
                    motionList[1][2]="\\"
            else:
                if(insSplited[2]=="in"):
                    motionList[2][2]=">"
                else:
                    motionList[2][2]="\\"
        else:
            if(insSplited[1]=="hand"):
                if(insSplited[3]=="head"):
                    motionList[1][0]=" "
                    motionList[0][0]="("
                elif(insSplited[3]=="hip"):
                    motionList[0][0]=" "
                    motionList[1][0]="<"
                elif(insSplited[3]=="start"):
                    motionList[0][0]=" "
                    motionList[1][0]="/"
            else:
                if(insSplited[2]=="in"):
                    motionList[2][0]="<"
                else:
                    motionList[2][0]="/"
        for f in motionList:
            _out =''.join(str(i) for i in f)
            print(_out)
            
                    
             
