<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
   aria-controls="collapseExample">
    Second authority
</a>
<#if confirmError??>
        <div class="alert alert-danger" role="alert">
            ${confirmError}
        </div>
</#if>
<div class="collapse show" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <div class="custom-file">
                    <label class="custom-file-label" for="twiceReg">Input pass phrase.</label>
                    <input type="text" name="passPhrase" id="twiceReg" />
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="hidden" name="id" value="<#if message??>${message.id}</#if>" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>
</div>
