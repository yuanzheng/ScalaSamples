
# coding: utf-8

# In[149]:

import csv
import sys
import matplotlib.pyplot as plt
import numpy as np
import datetime
import time
from matplotlib.dates import DateFormatter, MinuteLocator

def splitTime(time):
    timeElements = time.split(':')
    seconds = timeElements[2].split('.')
    timeElements[2] = seconds[0]
    timeElements.append(seconds[1])
    return timeElements

def timeDiff(t1, t2):
    print "%s and %s"%(t1,t2)
    
    diff = t2 - t1
    result = diff.seconds + diff.microseconds/1E6
    print "result: %s"%result
    return result


def plotChartFromCSV(fileName):
    f = open(fileName, 'rt')
   
    try:
        reader = csv.reader(f)
        #["5,17:19:54.123,5,17:20:02.590", "4,17:19:54.255,4,17:20:03.805","6,17:19:54.341,6,17:20:02.479"]
        #["5","17:19:54.123","5","17:20:02.590"] 
        timeRef = 0
        errors = 0
        error_message = []
        sumDuration = 0.0
        counter = 0
        for splitedRead in reader:
            #splitedRead = row.split(',')
            #csv.reader(f)
            #for row in splitedRead:
            if splitedRead[0] == splitedRead[2]:
                print "%s -> %s"%(splitedRead[1],splitedRead[3])
                t1 = splitTime(splitedRead[1])
                t2 = splitTime(splitedRead[3])
                
                sT = datetime.datetime(2015, 9, 8, int(t1[0]), int(t1[1]), int(t1[2]))
                eT = datetime.datetime(2015, 9, 8, int(t2[0]), int(t2[1]), int(t2[2]))
                
                sumDuration += timeDiff(sT, eT)
                counter += 1
                startT = int(time.mktime(time.strptime(str(sT), '%Y-%m-%d %H:%M:%S'))) * 1000 + int(t1[3])
                endT = int(time.mktime(time.strptime(str(eT), '%Y-%m-%d %H:%M:%S'))) * 1000 + int(t2[3])
                if timeRef == 0:
                    timeRef = startT
                    
                print "Timestamp: %d v.s. %d"%(startT,endT)
                print "Num: %f => %f"%((startT-timeRef)/10000, (endT-timeRef)/10000)
                x = [(startT-timeRef)/10000, (endT-timeRef)/10000]
                y = [splitedRead[0], splitedRead[0]]
                plt.step(x, y)
            else:
                errors += 1
                error_message.extend(splitedRead)
        
        print "Error: %d"%errors
        print (error_message)
        print "Total %d processes, and average duration is %f"%(counter, (sumDuration)/counter)
        axes = plt.gca()
        #plt.gca().xaxis.set_major_locator( MinuteLocator(byminute=range(0,60,10)) )
        #plt.gca().xaxis.set_major_formatter( DateFormatter('%H:%M:%S') )
        plt.xticks(np.arange(0,120, 2.0))
        #axes.set_xlim([0,120])
        axes.set_ylim([0,10])
        plt.show()
    finally:
        f.close()

    
    
if __name__ == '__main__':
    #path = "/Users/ysong/projects/Neuralytics/Sep9/NeuralyticThreads.csv"
    #path = "/Users/ysong/projects/Neuralytics/Sep9/NeuralyticPersonThreads.csv"
    #path = "/Users/ysong/projects/Neuralytics/Sep9/NeuralyticCompanyThreads.csv"
    #path = "/Users/ysong/projects/Neuralytics/Sep9/NeuralyticInteractionThreads.csv"
    path = "/Users/ysong/projects/Neuralytics/Sep9/AnonyInteractionThreads.csv"
    plotChartFromCSV(path)
    
    


# In[ ]:




# In[108]:

lst = []
l1 = ["heelo","world"]
l2 = ["good", "morning"]
lst.extend(l1)
lst.append(l2)
lst


# In[132]:

from datetime import datetime

def timeDiff(t1, t2):
    print "%s and %s"%(t1,t2)
    
    diff = t2 - t1
    result = diff.seconds + diff.microseconds/1E6
    print "result: %s"%result
    return result

def timeDuration():
    t1 = datetime(2015, 9, 8, 17, 19, 54, 123000)
    t2 = datetime(2015, 9, 8, 17, 20, 02, 590000)
    diff1 = timeDiff(t1, t2)
    print "diff1: %s"%diff1
    
    t3 = datetime(2015, 9, 8, 17, 19, 54, 255000)
    t4 = datetime(2015, 9, 8, 17, 20, 03, 805000)
    diff2 = timeDiff(t3, t4)
    print "diff2: %s"%diff2
    
    ave = (diff1 + diff2)/2
    print "average duration: %s"%ave
    
if __name__ == '__main__':
    timeDuration()


# In[123]:

from datetime import datetime
t2 = datetime(2015, 9, 8, 17, 20, 02, 999999)
print "result: %s"%t2


# In[ ]:



