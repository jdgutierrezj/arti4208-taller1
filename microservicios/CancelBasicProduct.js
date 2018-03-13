'use strict';

const doc = require('dynamodb-doc');
const dynamodb = new doc.DynamoDB();

exports.handler = (input, context, callback) => {
  console.log('Received input:', JSON.stringify(input, null, 2));
  if (input.fail_cancel_basic_product) {
    callback("Internal Server Error");
  } else {
    console.log("ID " + input.CreateBasicProductResult.idproduct);
    console.log("idcustomer " + input.CreateBasicProductResult.idcustomer);

    let req = {
      TableName: "Product",
      Key:{
          "ID": input.CreateBasicProductResult.idproduct
      }
    }
    
    var parameters = null ;
    parameters = { 
        "idproduct": input.CreateBasicProductResult.idproduct
    }
    
    dynamodb.deleteItem(req,function(err, data) {
      if (err) console.log(err);
      else console.log(data);
    });
    
    console.log("callback parameters = ["+JSON.stringify(parameters,null,2)+"]");
    
    callback(null, parameters);
  }
};
