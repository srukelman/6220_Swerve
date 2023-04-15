from bs4 import BeautifulSoup as bs
import requests as rq
import operator as op
from datetime import datetime,timedelta,date
import csv

cfilename = "robots.csv"
c = open(cfilename,"a",newline="")
c.close()
wlt = ""

def csvwriter(row):
    with open (cfilename, 'a',newline='') as c:
        writer = csv.writer(c)
        writer.writerow(row)
        
def csvinit(fields):
    with open (cfilename, 'w',newline='') as c:
        writer = csv.writer(c)
        writer.writerow(fields)

def scraper(url):
    global wlt
    headers = { 
        'User-Agent'      : 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 
        'Accept'          : 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8', 
        'Accept-Language' : 'en-US,en;q=0.5',
        'DNT'             : '1', # Do Not Track Request Header 
        'Connection'      : 'close'
    }
    source = rq.get(url, headers=headers).text
    soup = bs(source, 'lxml')
    #print(soup.find('h2',class_="visible-xs end_header"))
    name = soup.find('h2',class_="visible-xs end_header").text
    index = name.index("-")
    name = name[index+1:]
    name = name.strip()
    wlt = soup.find('div', class_="col-xs-12 col-sm-9 col-lg-10").find('strong').text #win-lettuce-tomato
    print(wlt)
    while(True):
        try:
            index = wlt.index("-")
            break
        except:
            wlt = soup.find('div', class_="col-xs-12 col-sm-9 col-lg-10").find_all('strong')[1].text
            continue
    wins = wlt[:index]
    lt = wlt[index+1:]
    index = lt.index("-")
    ties = lt[index+1:]
    losses = lt[:index]
    return name, wins,losses, ties


def main():
    fields = ["TEAM #", "TEAM NAME", "2022 MP",  "2022 WINS", "2022 LOSSES", "2022 TIES", "W/L", "W/L ADJ"]
    nums = [812,867,968,987,1160,1538,1661,1884,2637,2839,3020,3309,3476,3501,3882,3952,4014,4019,
            4079,4123,4141,4183,4276,4322,4415,4619,4984,5025,5137,5199,5461,5805,5835,5857,6072,
            6220,6499,6560,6695,7042,7137,7157,7230,7447,8521,9271]
    csvinit(fields)
    for i in nums:
        url = "https://www.thebluealliance.com/team/"+ str(i)+ "/2022"
        name, wins, losses, ties = scraper(url)
        wins= int(wins)
        losses = int(losses)
        ties = int(ties)
        mp = wins + losses + ties
        wl = wins/losses
        wladj = (wins + (0.5 * ties))/losses
        args = [i, name, mp, wins, losses, ties, wl, wladj]
        csvwriter(args)

if __name__ == "__main__":
    main()