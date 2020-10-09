	
	
	var mv1 = new Vue({
		el:'#app1',
		data:{
			message:'hello'
		}
	});

	var mv2 = new Vue({
		el:'#app2',
		data:{
			message:new Date().toLocaleString() + '点点点'
		}
	});

	var mv3 = new Vue({
		el:'#app3',
		data:{
			see:true
		}
	});