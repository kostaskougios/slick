select *
from category c
left outer join product_category pc on pc.category_id=c.id
left outer join product p on p.id=pc.product_id
left outer join product_attribute pa on p.id=pa.product_id
left outer join attribute a on a.id=pa.attribute_id
