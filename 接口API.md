域名：www.guohanghuang.cn:8443

**url：/login**

**参数：code,nickName,avatarUrl**

**返回：openId，phone，integral**  //如果不是vip用户integral为-1

错误信息：

1.code为空或错误，返回400

2.服务器连接微信后台失败，返回504

 

获取短信：

**url：/getSms**

**参数：phone**

返回：4位数字

错误信息：500，后台出错，请重试

 

设置用户手机号

**url：/setPhone**

**参数：openId，phone**

返回：手机号码

错误信息：返回400，参数错误

 


获取所有商品：

**url:/goods**     

**参数：openId**

返回：

1.如果是vip用户：

[

​    {

   "maxPrice": 5500,
    //商品价格范围
    
   "minPrice": 4665,

​        "priceId": 1,                 //商品id

​        "name": "test",      //商品名

​        "detail": "detail",   //商品详情

​        "pictures": [           //商品轮播图片

​            "test.img"

​        ],

​        "priceList": [     //商品价格列表

​            {

​                "priceId": 1,                  //价格id

​                "price": 4665,        //价格，单位为分，前端需除以100换成元显示
                "integral": 21,       //vip用积分购买需要花费的积分

​                "num": 100,          //库存

​                "models": [      //商品型号

​                    {

​                        "smallModelName": "180",  //小型号

​                        "bigModelName": "尺寸"    //大型号

​                    },

​                    {

​                        "smallModelName": "蓝色",    //小型号

 

​                        "bigModelName": "颜色"   //大型号

 

​                    }

​                ]

​            },

​            {

​                "id": 2,

​                "price": 5500,

​                "num": 100,

​                "models": [

​                    {

​                        "smallModelName": "绿色",

​                        "bigModelName": "颜色"

​                    }

​                ]

​            }

​        ],

​        "integral": 1,   //卖出一件商品可得的vip积分

​        "batch": 100,    //商品起批量

​        "allRetail": 0,     //商品总零售量

​        "monthRetail": 0   //商品本月零售量

​    }

]

 

2.如果是普通用户：

[

​    {

   "maxPrice": 5500,
    //商品价格范围
    
   "minPrice": 4665,
   
​        "priceId": 1,                 //商品id

​        "name": "test",      //商品名

​        "detail": "detail",   //商品详情

​        "pictures": [           //商品轮播图片

​            "test.img"

​        ],

​        "priceList": [     //商品价格列表

​            {

​                "priceId": 1,                  //价格id

​                "price": 4665,        //价格，单位为分，前端需除以100换成元显示

​                "num": 100,          //库存

​                "models": [      //商品型号

​                    {

​                        "smallModelName": "180",  //小型号

​                        "bigModelName": "尺寸"    //大型号

​                    },

​                    {

​                        "smallModelName": "蓝色",    //小型号

 

​                        "bigModelName": "颜色"   //大型号

 

​                    }

​                ]

​            },

​            {

​                "id": 2,

​                "price": 5500,

​                "num": 100,

​                "models": [

​                    {

​                        "smallModelName": "绿色",

​                        "bigModelName": "颜色"

​                    }

​                ]

​            }

​        ],

​    }

]

 

 

获取单个收货地址：

**url:/address/singleAddress**

**参数：addressId**



获取默认地址：
 **url：/getDefaultAddress**

**参数：openId**

 

 

获取用户所有收货地址：

**url:/address**

**参数：openId**

返回：

[

​    {

​        "openId": null,  

​        "id": 4, //收货地址id

​        "name": "hgh", //收货人

​        "address": "北京路",  //收货地址

​        "phone": "13724125552", //收货人手机号

​        "state": 0  //是否为默认收获地址，1为默认，0为非默认

​    },

​    {

​        "openId": null,

​        " id ": 7,

​        "name": "123",

​        "address": "1231",

​        "phone": "12313",

​        "state": 1

​    }

]

 

添加收货地址：

**url:/addAddress**
**json格式**
参数：

{

​        "openId": "test",   //openId

​        "name": "123",      //收货人姓名

“detailAddress”：“1231”//门牌号

​        "address": "12312311",  //收货地址

​        "phone": "12313121",   //收货人电话   

}

错误信息：400参数错误，500，后台出错

 

修改收获地址：

**url:/updateAddress**
**json格式**
参数：

{

​        "id": 1,   //收货地址id

​        "name": "123",      //收货人姓名

​        "address": "12312311",  //收货地址

​        "phone": "12313121",   //收货人电话   

}

错误信息：400参数错误，500，后台出错

 

设置默认收货地址：

**url: /updateStateForAddress**

**参数：openId, addressId**

错误信息：400参数错误，500，后台出错

 

 

删除收货地址：

**url:/deleteAddress**

**参数：addressId**

错误信息：400参数错误，500，后台出错

 

 

获取单个商品：

**url:/goods/singleGoods**

**参数：goodsId,openId**

返回：

{

   "maxPrice": 5500,
    //商品价格范围
    
   "minPrice": 4665,

​    "goodsId": 1,

​    "name": "test",

​    "detail": "detail",

​    "pictures": [

​        "123",

​        "321"

​    ],

​    "priceList": [

​        {

​            "priceId": 1,

​            "price": 4665,

​            "num": 100,

​            "models": [

​                {

​                    "smallModelName": "180",

​                    "bigModelName": "尺寸"

​                },

​                {

​                    "smallModelName": "蓝色",

​                    "bigModelName": "颜色"

​                }

​            ]

​        },

​        {

​            "priceId": 2,

​            "price": 5500,

​            "num": 100,

​            "models": [

​                {

​                    "smallModelName": "绿色",

​                    "bigModelName": "颜色"

​                }

​            ]

​        }

​    ]

}


获取某个二级分类的商品：

**url：/goods/typeGoods**

**参数：typeId**

按名字获取的商品：

**url:/goods/nameGoods**

**参数：name**

增加商品评论：
 
**url：/insertComments**

**参数：openId, content, star,  goodsId, orderformGoodsId** 

//其中star 1表示好评，2表示中评，3表示差评，orderformGoodsId为订单中某行的id

返回：评价成功返回true，200；失败返回false，400

获取商品的评论:

**url:/ comments**

**参数：goodsId**

返回：

[

​    {

​        "userInfo": {

​            "nickName": "hgh123", //用户昵称

​            "avatarUrl": "mytest.img"  //用户头像

​        },

​        "content": "test", //评论的内容

​        "star": 5,      //评论星数

​        "createTime": "2018-10-17",  //评论时间

​        "modelNames": [      //购买商品的类型

​            "蓝色"，

​                     “180”，

​                     “秋季下装”

​        ]

​    }

]

 

 

获取购物车：

**url：/shoppingcar**

**参数：openId**

返回：

[

​    {

​        "shoppingcarId": 2,   //购物车的行id

​        "shoppingcarGoods": {   //购物车这一行的商品

​            "goodsId": 1,       //

​            "goodsName": "test",  //商品名

​            "goodsPicture": "123" //商品图片

​        },
        "priceId":1,    //价格id

​        "price": 5500,  //价格

​        "priceModels": [   //商品的类型

​            "绿色"，

​                     “180”，

​                     “下装”

​        ],

​        "buyNum": 21,  //购买数量

​        "state": 0   //是否选中，1为选中

​    }

]

 

删除购物车里某一行的商品：

**url：/deleteShoppingcar**

**参数：shoppingcarId**

返回：成功返回状态码200，true；失败返回状态码400，false

 
修改购物车里商品购买数量：

**url：/updateBuyNumForShoppingcar**

**参数：buyNum，shoppingcarId**

返回：成功返回状态码200，true；失败返回状态码400，false

 
 添加购物车商品：
 **url:/insertShoppingcar**
 **参数：openId,buyNum,priceId,goodsId**
 
 
修改购物车的商品是否选中：

**url:/updateStateForShoppingcar**

**参数：state, shoppingcarId**

返回：成功返回状态码200，true；失败返回状态码400，false

获取满减、折扣：
**url:/getDiscount**

**参数：openId**

返回:
1.如果是vip用户，返回null；

2.如果是普通用户，返回：

{
    "discountCondition": 10000, //满减条件，单位分
    
   "reduce": 100,      //减多少分钱
    
   //以上两个参数的意思是：满100元减1元
   "discount": 7.5,    //打多少折
   
   "start": “2018-10-22 23:30:33”,    //限时折扣开始时间
   
   "end": "2018-10-26 23:30:33"        //结束时间
   
   以上三个参数的意思是：限时2018-10-22 23:30:33-2018-10-26 23:30:33全部商品打7.5折
}

注：如果reduce为0，说明没有设置满减，就不用显示满减的情况；

如果discount为0，说明没有设置折扣，就不用显示折扣的情况。如果reduce和discount都为0，则不用显示。


获取赠品：
**url：/getGift**

**参数：openId**

返回:
1.如果是vip用户，返回null；
2.如果是普通用户，返回：

{
    "goodsId": 1,  //赠品的id
    
   "goodsPicture": "123.img", //赠品的图片
    
   "goodsName": "test",  //赠品名称
    
   "num": 1  //赠送数量
}

注意：如果goodsId为0，则没有赠品，不用显示

获取运费：
**url：/getTransportFree**

**参数：无**

返回：

{
    "feeConditions": 10000,  //满多少分钱包邮
    
   "fee": 800 //否则收取运费多少分钱
}


生成订单：

**url:/insertOrderform**

**参数：**

{
"openId":"test",  

"insertOrder": true, //是否使用积分支付

"name":"hgh",  //收货地址中的收货人

"address":"北京市周口店",  //收货地址中的地址

"phone":"123131313",    //收货人电话

"giftId":1,         //赠品id

"giftNum":10,           //赠品数量

"transportFee":1000,    //运费，单位分

"sumFirst":10000,       //原价

"sumFinal":11000,          //加上运费和折扣后的价格

"remarksWhenOrder":"尽快发货，老板",      //下单备注

"orderformGoods":[      //订单中的商品

{

"goodsName":"测试商品1",
	
"goodsPicture":"http://www.pptbz.com/pptpic/UploadFiles_6909/201211/2012111719294197.jpg",
			
"goodsId":1,

"priceId":1,

"goodsPrice":10000,     

"buyNum":2,

"priceModels":[
"蓝色","180","下装"
]

}

]

}

获取所有订单：

**url:/getOrderformByOpenId**

**参数：openId**

获取一个订单：

**url:/getOrderformByOrderformId**

**参数：orderformId**

更改订单：

**url：/updateOrderform**

参数：orderformId, //订单id

   state, //订单状态0待支付，1待发货，2申请退款，3同意退款，4退款成功，5退款失败，6已发货，7已完成，8已关闭（已失效）
    
   remarksWhenRefund  //申请退款理由

注意：上面的remarksWhenRefund只在申请退款的时候需要，其他时候不需要

获取轮播图：

**url：/getBanner**

返回：[
"123.img","123.img","31.img"
]


获取商品大类
**url:/bigTypes**

参数：无

返回：[

{
"typeId":1,
"name":"广东"
},

{
"typeId":2,
"name":"上海"
}，

{
"typeId":3,
"name":"北京"
}

]

获取商品二级分类：

**url:/smallType**

**参数：typeId(大类id)**

返回：[

{
"typeId":1,
"name":"广州"
},

{
"typeId":2,
"name":"深圳"
},

{
"typeId":3,
"name":"黄浦区"
},

{
"typeId":4,
"name":"四合院"
}

]

