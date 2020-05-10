# trade-shoes
shoes商城后端代码

| 服务名称 | 功能 |
|------|------------|
| trade-shoes-common  | 公共包：用来存放一些各个服务公共的常量、枚举等信息          |
| trade-shoes-gateway  | 网关服务：路由转发、鉴权        |
| trade-shoes-user  | 用户服务：存储用户信息，提供用户相关接口       |
| trade-shoes-order  | 订单服务：存储商品信息，及用户下单流程提供者       |
| trade-shoes-capital  | 资金服务：存储用户资金相关信息，提供资金增加减及第三方相关接口       |
| trade-shoes-integral  | 积分服务：用户下单产生积分，本服务用来计算积分相关信息       |
| trade-shoes-poundage  | 手续费服务：用户下单及充值扣取手续费，按比例计算金额，分到每位收款用户的资金账户中       |