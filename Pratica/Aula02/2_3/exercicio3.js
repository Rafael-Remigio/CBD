function groupByPrefix() {    var resultado =db.phones.aggregate([{$group: {_id:"$components.prefix", count: {$sum: 1}}},{$sort: {count: -1}}]); printjson(resultado._batch);};

function capicua() {
    var result = db.phones.find();
    while (result.hasNext()){
        id = result.next()._id;
        str = id.toString();
        // Step 2. Create the FOR loop
        var len = str.length; // var len = "A man, a plan, a canal. Panama".length = 30
        var pali = true;
        for (var i = 0; i < len/2; i++) {
            if (str[i] !== str[len - 1 - i]) { // As long as the characters from each part match, the FOR loop will go on
                pali = false;
                break; // When the characters don't match anymore, false is returned and we exit the FOR loop
            }
        }
        if (pali){
            print(str);
        }


    }
};

