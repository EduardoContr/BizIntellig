from flask import Flask, jsonify, request
app = Flask(__name__)

@app.route('/')
def hellow():
    return "enduser connects! aye", "endUser gets two statements for the price of one and a half"
    
@app.route('/a')
def yes():
    retJson = {
"arr1":['Symbol,Bid,Ask,Price,Chg1,Chg2,Open,High,Low,Volume,Date'],
"arr2":['COMP',3.96,3.97,3.96,0.255,6.87,3.74,3.97,3.69,'1.64M','2023-05-17'],
"arr3":['WYNN',109.78,109.82,109.79,6.74,6.54,106.39,111.05,105.5,4.58,'2023-05-17']
}
    return jsonify(retJson)

@app.route('/aver3', methods=["POST"])
def yess():
    sending = request.get_json() 
    a = sending["comp1"]
    b = sending["comp2"]
    c = sending["comp3"]
    d = sending["comp4"]
    alst1 = ["this is yesterdays price at close,", a]
    alst2 = ["this is yesterdays open,", b]
    alst3 = ["this is yesterdays high,", c]
    alst4 = ["this is yesterdays low,", d]
    #created list appended with a
    
    list = [a,b,c,d]
    alist = sum(list)
    length = len(list)
    
    retJson = {
    
        "a headline": alst1,
        "note1:": alst2,
        "analysis-Mean": alist/length
    
    }
    
    return jsonify(retJson), 200
    
if __name__=="__main__": 
    app.run()    
