GenGetSet
---------

idea插件，可以根据实体快速生成对应的set+get方法，基本替代了BeanUtils拷贝属性方法。

用法
---------

```
//假设为数据库查询Pojo
class Entity {
    private Integer id;
    private Integer num;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//展示层用Vo
class EntityVo {
    private Integer id;
    private Integer num;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

主方法如下
```
    public static void main(String[] args) {
        Entity entity = new Entity();
        EntityVo vo = new EntityVo();
        entity.getset//根据代码提示完成
    }

    public static void main(String[] args) {
        Entity entity = new Entity();
        EntityVo vo = new EntityVo();
        entity.setId(.getId());
        entity.setNum(.getNum());
        entity.setName(.getName());
    }
    根据模板填充vo，得到
    public static void main(String[] args) {
        Entity entity = new Entity();
        EntityVo vo = new EntityVo();
        entity.setId(vo.getId());
        entity.setNum(vo.getNum());
        entity.setName(vo.getName());

    }

```

支持模板
-----------

- getset模板
    - 直接生成po.setXXX(obj.getXXX)
- genset模板
    - 直接生成po.setXXX()