import pymongo
import sys
import random
from random import randrange


def __main__(numberOfCats):


    myclient = pymongo.MongoClient("mongodb://localhost:8765/")
    mydb = myclient["cbd"]
    mycol = mydb["cats"]


    #cat names and breeds
    f = open('CatNames.txt', 'r+')
    catNames = [line.replace("\n","") for line in f.readlines()]
    f.close()
    f = open('cat-breeds.txt', 'r+')
    catBreeds = [line.replace("\n","") for line in f.readlines()]
    f.close()
    catCoatColors = ["black","orange","grey","cream","chocolate","fawn","cinnamon","smoke","red","red silver","calico","tuxedo","sealpoint"]
    maxlife = 18
    catFood = ["Complete Essentials Chicken & Rice Formula","Complete Essentials Chicken & Egg Formula","Hairball Management Chicken & Rice Formula","Indoor Salmon & Rice Formula","Indoor Turkey & Rice Formula","Sensitive Skin & Stomach Turkey & Oat Meal Formula","Sensitive Skin & Stomach Lamb & Rice Formula","Shredded Blend Indoor Turkey & Rice Formula","Development Chicken Entrée Grain Free Classic Wet Cat Food","Development Chicken & Liver Entrée Classic Wet Cat Food"]
    minimumCatWeigth = 2
    maxCatWeigth = 9
    diseases = {"Kidney Disease": ["Frequent urination","Weight loss","Drinking a lot of water"],"Dental Issues": ["Gingivitis","Periodontitis","bleeding gums"],"Diabetes": ["Weight loss","Dehydration","Change in appetite","Sweet-smelling breath"],"Feline Immunodeficiency Virus": ["Gingivitis","Poor coat condition","Fever"],"Feline Leukemia Virus": ["Seizures","Diarrhea","Weight loss","Fever"],"Cancer": ["Weight loss","Anorexia","Diarrhea"],"Obesity": [],"Pancreatitis":["Vomiting","Fever","Diarrhea","Abdominal pain"],"Hyperthyroidism":["Weight loss","Increased appetite"],"Broken Bones": [],"High-Rise Syndrome": [],"Fleas": ["Scratching","hair loss"],"Tapeworms":[],"Eye Problems":["Dizziness"],"Heartworms": ["Weight Loss","Lethargy"],"Rabies": ["Fever"],"Ringworm": ["Scratching"],"Constipation": ["Bloody feces","Change in appetite"],"Food Allergies": [],"Feline Lower Urinary Tract Diseases (FLUTD)": ["Pain","Blood in Urine","Frequent urination"]}

    #People names
    f = open('firstNames.txt', 'r+')
    firstNames = [line.replace("\n","") for line in f.readlines()]
    f.close()
    f = open('lastNames.txt', 'r+')
    LastNames = [line.replace("\n","") for line in f.readlines()]
    f.close()
    f = open('cities.txt', 'r+')
    cities = [line.replace("\n","") for line in f.readlines()]
    f.close()


    for i in range(numberOfCats):
    # Generating random cat
        mycat = {}
        mycat["name"] = random.choice(catNames)
        mycat["breed"] = random.choice(catBreeds)
        mycat["color"] = random.choice(catCoatColors)
        mycat["birthYear"] = randrange(2022 - maxlife,2022)
        mycat["weight"] = randrange(minimumCatWeigth,maxCatWeigth)

        mycat["Diet"] = []
        for i in range(randrange(1,3)):
            food = random.choice(catFood)
            if food not in mycat["Diet"]:
                mycat["Diet"].append(food)

        #generating Owner
        catOwner = {}
        catOwner["name"] =  random.choice(firstNames) + " " + random.choice(LastNames)
        catOwner["city"] = random.choice(cities)
        pho_no = "9"
        for i in range(8):
            pho_no = pho_no + str(random.randint(0, 9))
        catOwner["phone"] = pho_no

        mycat["diseases"] = []
        for i in range(3):
            d = random.randint(0,len(diseases) * 2) 
            if d >= len(diseases):
                break
            disease = {}
            lista = list(diseases.keys())
            disease["nome"] = lista[d]
            disease["discoveryYear"] = random.randrange(int(mycat["birthYear"]),2022)
            disease["symptoms"] = diseases[lista[d]]

            mycat["diseases"].append(disease)

        mycat["owner"] = catOwner
        
        print(mycol.insert_one(mycat))


    return


if __name__ == "__main__":
    numberOfCats = int(sys.argv[1])
    __main__(numberOfCats)