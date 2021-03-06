Gem::Specification.new do |s|
  s.name        = 'grabzit'
  s.version     = '3.0.0'
  s.date        = Date.today.to_s
  s.summary     = "GrabzIt Ruby Client"
  s.description = "Use GrabzIt to take PDF or image screenshots of websites or convert HTML to images or PDF's. These captures have highly customizable options include altering quality, delay, size, browser type, geographic location and much more. Additionally GrabzIt can even convert HTML tables on the web into a CSV or Excel spreadsheet. As well as enabling online video's to be converted into animated GIF's."
  s.authors     = ["GrabzIt"]
  s.require_paths = ["lib"]
  s.email       = 'support@grabz.it'
  s.files       = ["Rakefile", "lib/grabzit.rb", "lib/grabzit/client.rb","lib/grabzit/cookie.rb","lib/grabzit/screenshotstatus.rb", "lib/grabzit/watermark.rb", "lib/grabzit/exception.rb", "lib/grabzit/baseoptions.rb", "lib/grabzit/utility.rb", "lib/grabzit/animationoptions.rb", "lib/grabzit/request.rb", "lib/grabzit/tableoptions.rb", "lib/grabzit/imageoptions.rb", "lib/grabzit/pdfoptions.rb", "test/test.png", "test/test_grabzit.rb"]
  s.homepage    = 'http://grabz.it/api/ruby'
  s.add_dependency('rake')
end
