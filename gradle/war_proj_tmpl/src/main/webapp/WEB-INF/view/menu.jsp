<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div class="menus">
<div id="menuSheath">
	<div id="menu1" class="menu">
		<a id="link_menu1" href="./menu1_url.htm" class="">Menu1</a>
		<ul></ul>
	</div>
	<div id="menu2" class="menu">
		<a id="link_menu2" href="./menu2_url.htm" class="">Menu2</a>
		<ul>
			<li><a id="link_menu2" href="./menu2_item1_url.htm" class="">Menu2-Item1</a></li>
		</ul>
	</div>
</div>		
	<br>
</div>

<script type="text/javascript">    
    $(document).ready( function() {
    		$('#menu_${menu_item}').removeClass('menu').addClass('menu home');
    		$('#link_menu_${menu_item}').addClass('there');
    });
    
</script> 