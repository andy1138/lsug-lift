package net.lsug.snippet

import xml.{NodeSeq}
import net.liftweb._
import util.Helpers._

import scalax.io._
import net.liftweb.json._
import net.liftweb.json.JsonAST.JField

class EventsList {
//	def render = "*" #> <strong>Events ListXX!</strong>
	
	def title = {
		val request = "http://api.meetup.com/events?radius=25.0&order=time&group_urlname=london-scala&offset=0&format=json&page=200&fields=&sig_id=7392840&sig=ab5d1ad6b657ec13b8898fd6a2c63fed7816aa5a"
		val in = new String(Resource.fromURLString(request).bytes.toArray)
		println("Out>> " + in)
		
		val json = JsonParser.parse(in)
		val titles = json \\ "name"
//		println("Out title>> " + titles.children)
		
		val title = ((json \\ "name").children).map {
			case JField(name, value) => println("event " + value.values); value.values 
			case _ => ""
		}

		val time = ((json \\ "time")).children.map {
			case JField(name, value) => println("event " + value.values); value.values 
			case _ => ""
		}

		
		<span> <h2> Events List</h2>  {title.head} {time.head}  </span> 
	}
	


// JObject(List(JField(name,JString(Concurrency and Complex Event Processing in action with Scala)), JField(name,JString(LSUG Scala Dojo)), JField(name,JString(Jonas Boner's Pragmatic Real-World Scala (2days,pay))), JField(name,JString(Jonas Boner's Akka Overview Workshop (pay)))))
	
}